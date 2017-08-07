//package instrument;
//
//import java.lang.instrument.ClassFileTransformer;
//import java.lang.instrument.Instrumentation;
//
///**
// * Created by liqing.zhan on 2016/10/19.
// */
//public class PerfMonAgent {
//    private static Instrumentation instrumentation;
//
//    public static void premain(String args, Instrumentation instrumentation) {
//        instrumentation = instrumentation;
//        System.out.println("Instrumentation Start");
//        ClassFileTransformer transformer = new PerfMonXformer();
//        System.out.println("add ClassFileTransformer" + transformer.getClass().getSimpleName());
//        instrumentation.addTransformer(transformer);
//    }
//}
