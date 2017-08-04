package instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * Created by liqing.zhan on 2017/3/9.
 */
public class LoadClassInst {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("LoadClassInst premain start");
        inst.addTransformer(new LoadClassTransformer());
        System.out.println("LoadClassInst premain end");
    }
}

class LoadClassTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer)
            throws IllegalClassFormatException {
        System.out.println(String.format("load class %s", className));
        return classfileBuffer;
    }
}
