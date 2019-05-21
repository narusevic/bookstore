package lt.vu.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@MyInterceptor
public class InterceptorImpl {
    @AroundInvoke
    public Object doSomeStuff(InvocationContext ctx)
            throws Exception {
        System.out.println("interceptor");
        return ctx.proceed();
    }
}

