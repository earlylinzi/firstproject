package com.myutil.project.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sfbest.framework.paging.ConditionOperator;
import com.sfbest.framework.paging.MultiSearchCondition;
import com.sfbest.framework.paging.PagingResult;
import com.sfbest.framework.paging.SearchCondition;
import com.sfbest.framework.paging.SearchModel;
import com.sfbest.message.sms.api.SmsManagerService;
import com.sfbest.message.sms.entity.MsgNotes;

public class PoiOut {
	
	
	public static void main(String[] args)  {
	
		List<MsgNotes> msgList = getMsgByTel(null,1495008000000L,1495011600000L,null);
		
		String[] headers = {"","主键ID","大网返回的ID","短信类型","手机号","内容","发送状态","重发次数","时间戳","携带ip","发送渠道","子渠道号"};
		
		try {
			OutputStream out = new FileOutputStream("E:/666.xls");
		
			createWorkBook("短信记录",headers,msgList,out,"yyyy/MM/dd HH:mm:ss");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ok!");
	}



	/**
	 * 
	 * @param <T>
	 * @param title
	 *            表格的标题
	 * @param headers
	 *            每一列的列标题
	 * @param dataset
	 *            数据源 类型是Collection
	 * @param out
	 *            输出流
	 * @param pattern
	 *            如果有日期日期的转换格式
	 * @throws Exception
	 *             可抛出的异常
	 */
	@SuppressWarnings("unchecked")
	public static <T> void createWorkBook(String title, String[] headers, Collection<T> dataset, OutputStream out,String pattern) throws Exception {

		HSSFWorkbook book = new HSSFWorkbook();

		HSSFSheet sheet = book.createSheet(title);

		HSSFRow row = sheet.createRow(0);

		// 设置标题行
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(headers[i]);
		}

		// 遍历集合数据产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			T t = (T) it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				Class tCls = t.getClass();
				if(getMethodName.equals("getSerialVersionUID")){
					continue;
				}
				Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
				if(null != getMethod){
						Object value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					if (value instanceof Integer) {
						int intValue = (Integer) value;
						cell.setCellValue(intValue);
					} else if (value instanceof Float) {
						float fValue = (Float) value;
						cell.setCellValue(fValue);
					} else if (value instanceof Double) {
						double dValue = (Double) value;
						cell.setCellValue(dValue);
					} else if (value instanceof Long) {
						long longValue = (Long) value;
						String format = sdf.format(longValue);
						cell.setCellValue(format);
					} else if (value instanceof Boolean) {
						boolean bValue = (Boolean) value;
						String textValue = "True";
						if (!bValue) {
							textValue = "False";
						}
						cell.setCellValue(textValue);
	
//					} else if (value instanceof Date) {
//						Date date = (Date) value;
//						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//						String textValue = sdf.format(date);
//						cell.setCellValue(textValue);
					}else if(null == value){
						String textValue = "";
					}else {
						// 其它数据类型都当作字符串简单处理
						String textValue = value.toString();
						cell.setCellValue(textValue);
					}
				}
			}
		}
		book.write(out);
	}
	
	
	//根据条件查询信息记录
	public static List<MsgNotes> getMsgByTel(String tel,long startTime,long endTime,String content){
		
		String url = "http://10.102.32.75:8080/hessian/smsManagerService";
        HessianProxyFactory factory = new HessianProxyFactory();
        
        try {
        	
        	SmsManagerService service= (SmsManagerService) factory.create(SmsManagerService.class, url);
        	
        	
        	SearchModel sm = new SearchModel();
        	sm.setPage(1);
        	sm.setPageSize(100000);
        	List<SearchCondition> searchConditionList = new ArrayList<SearchCondition>();
        	//按内容查询
        	if(content != null && !"".equals(content.trim())){
	        	SearchCondition sc3 = new SearchCondition();
	        	sc3.setName("msgContent");
	        	sc3.setOperateType(ConditionOperator.LIKE);
	        	sc3.setValue(content);
	        	searchConditionList.add(sc3);
        	}
        	//按日期查询
        	MultiSearchCondition sc2 = new MultiSearchCondition();
        	sc2.setName("msgDate");
        	if( 0 != startTime){
        		sc2.setOperateType(ConditionOperator.GTE);
        		sc2.setValue(startTime);
        	}
        	if(0 != endTime){
        		sc2.setOperateType2(ConditionOperator.LTE);
        		sc2.setValue2(endTime);
        	}
        	//添加到条件集合中
        	searchConditionList.add(sc2);
        	
        	//按手机号查询
        	if(tel != null && "".equals(tel.trim())){
        		SearchCondition sc = new SearchCondition();
	        	sc.setName("msgTel");
	        	sc.setOperateType(ConditionOperator.EQ);
	        	sc.setValue(tel);
	        	searchConditionList.add(sc);
	        }
        	sm.setSearchConditionList(searchConditionList);
        	
        	PagingResult<MsgNotes> pageResult = service.findMsgNotesByPage(sm);
        	
        	return pageResult.getRows();
        
        } catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
        return null;
		
	}
}
