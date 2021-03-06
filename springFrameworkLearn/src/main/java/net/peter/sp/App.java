package net.peter.sp;

import net.peter.sp.aop.AnnotationAppConfig;
import net.peter.sp.domain.Video;
import net.peter.sp.domain.Video2;
import net.peter.sp.domain.VideoOrder;
import net.peter.sp.service.VideoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

// ===========================================================================
// 使用xml配置
//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("applicationContext.xml");

//        testScope(applicationContext);

//        testInject(applicationContext);

//        testAop(applicationContext);
//        testCollection(applicationContext);

//        testSucceed(applicationContext);

//        testInitAndDestroy(applicationContext);
// ===========================================================================

// 使用注解配置
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        // 扫描指定的包，包括子包
//        context.scan("net.peter.sp");
//
//        // 里面完成初始化操作核心方法
//        context.refresh();

//        VideoOrder videoOrder = (VideoOrder) context.getBean("videoOrder");
//
//        videoOrder.setId(23);
//
//        System.out.println(videoOrder.toString());

//        VideoService videoService = (VideoService) context.getBean("videoService");
//
//        videoService.printConfig();
//
//        VideoService videoService2 = (VideoService) context.getBean("videoService");
//
////        videoService.findById(40);
////        context.close();
//
//        System.out.println(videoService == videoService2);

// ======================================================================================

        // 使用AOP+注解配置的方式实现
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationAppConfig.class);

        VideoService videoService = (VideoService) context.getBean("videoService");

        videoService.printConfig();

    }


    /**
     * 测试scope作用域范围
     * @param context
     */
    private static void testScope(ApplicationContext context){
        Video video1 = (Video) context.getBean("video");

        Video video2 = (Video) context.getBean("video");

        // 判断引用地址，即内存地址是否相同
        System.out.println(video1 == video2);




    }

    /**
     * 测试inject注入的过程
     * @param context
     */
    private static void testInject(ApplicationContext context){

//        Video video = (Video) context.getBean("video");
//        System.out.println(video.getTitle());

        VideoOrder videoOrder= (VideoOrder) context.getBean("videoOrder");
        System.out.println(videoOrder.getVideo().getId());

    }

    /**
     * 测试List和Map格式注入
     * @param context
     */
//    private static void testCollection(ApplicationContext context){
//
//        Video video = (Video) context.getBean("video");
//        System.out.println(video.getChapterList().toString());
//        System.out.println(video.getVideoMap().values().toString());
//    }

    /**
     * 测试bean继承属性
     * @param context
     */
    private static void testSucceed(ApplicationContext context){
        Video2 video2 = (Video2) context.getBean("video2");
        System.out.println(video2.toString());
    }

    /**
     * 测试bean的初始化和销毁过程
     * @param context
     */
    private static void testInitAndDestroy(ApplicationContext context){

        Video video = (Video) context.getBean("video");
        System.out.println(video.getTitle());
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }

    /**
     * 测试AOP切面编程
     * @param context
     */
    private static void testAop(ApplicationContext context){

        VideoService videoService = (VideoService) context.getBean("videoService");

        videoService.save(new Video());

        videoService.findById(2);
    }
}
