package myannotations;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解解释器
 */
public class AnnoCreator {


    /**
     * 解析局部变量的注解
     *
     * @throws Exception
     */
    public static void annoFiled() throws Exception {
        Class<AnnoBean> clazz = AnnoBean.class;
        //创建实例
        AnnoBean annoBean = clazz.newInstance();
        //得到类中的所有定义的属性
        for (Field filed : clazz.getDeclaredFields()) {
            //得到属性的注解，对一个目标可以使用多个注解
            Annotation[] anns = filed.getAnnotations();//得到所有注解
            if (anns.length < 1) {
                continue;
            }
            //MyAge注解分析
            if (anns[0] instanceof FiledAnnoAge) {
                FiledAnnoAge filedAnnoAge = (FiledAnnoAge) anns[0];//注解的值
                String name = filed.getName();
                System.out.println("filedName_AGE:"+ name);
                int age = filed.getInt(annoBean);//实际的值
                System.out.println("AGE:"+age + filedAnnoAge.age() + "");//实际的值+注解的值
            }
            //MyName注解分析
            if (anns[0] instanceof FiledAnnoName) {
                FiledAnnoName filedAnnoName = (FiledAnnoName) anns[0];
                String name = filedAnnoName.value();
                String fileName = (String) filed.get(annoBean);
                String filedName = filed.getName();
                System.out.println("filedName_NAME:"+filedName);
                System.out.println("Name:"+name + fileName + "");

            }
        }
    }


    /**
     * 解析类的注解
     *
     * @throws Exception
     */
    public static void annoType() throws Exception {
        Class<AnnoBean> clazz = AnnoBean.class;
        TypeAnno typeAnno = clazz.getAnnotation(TypeAnno.class);//得到单个注解
        System.out.println("TableAnno:" + typeAnno.table());
    }



    /**
     * 解析方法的注解
     *
     * @throws Exception
     */
    public static void annoMethod() throws Exception {
        Class<AnnoBean> clazz = AnnoBean.class;
        //根据反射得到方法
        Method[] methods = clazz.getMethods();
        for (Method method:methods) {
            if (method.getName().equals("testAnno")){
                MethodAnno annotation = method.getAnnotation(MethodAnno.class);
                FiledAnnoAge filedAnnoAge = annotation.setAnnoAge();
                int age = filedAnnoAge.age();
                FiledAnnoName filedAnnoName = annotation.setAnnoName();
                String name = filedAnnoName.value();
                System.out.println("Method_ANno:"+age + name + annotation.method());
            }

        }
    }



}
