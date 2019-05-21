package lt.vu.decorators;

import lt.vu.asynchronous.ICompCSpec;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class PrintDecorator implements ICompCSpec {
    @Inject
    @Delegate
    @Any
    ICompCSpec account;

    public String getCompValue() {
        System.out.println("decorator");
        return account.getCompValue();
    }
}