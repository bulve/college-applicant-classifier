package classifier.model.factory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Finds first occurred {@link ClassifierModelFactory} implementation provided as service.
 *
 * @author Vasiliauskas
 */
public class ClassifierModelFactoryProvider {

    private static ClassifierModelFactory instance;

    private ClassifierModelFactoryProvider() {
    }

    public static ClassifierModelFactory getInstance(){
        if(instance == null) {
            Iterator<ClassifierModelFactory> factories = ServiceLoader.load(ClassifierModelFactory.class).iterator();
            if(factories.hasNext()){
                instance = factories.next();
                return instance;
            } else {
                throw new IllegalStateException("Cannot load ClassifierModelFactory");
            }
        }
        return instance;
    }
}
