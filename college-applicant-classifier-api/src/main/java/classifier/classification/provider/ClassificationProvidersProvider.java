package classifier.classification.provider;

import classifier.model.ClassificationProvider;

import java.util.*;

/**
 * Finds all {@link ClassificationProvider} implementation provided as services.
 *
 * @author Vasiliauskas
 */
public class ClassificationProvidersProvider {

    private static Collection<ClassificationProvider> providers;

    public static Collection<ClassificationProvider> getClassificationProviders() {
        if(providers == null) {
            List<ClassificationProvider> classificationProviders = new ArrayList<>();
            Iterator<ClassificationProvider> providerIterator = ServiceLoader.load(ClassificationProvider.class).iterator();
            while (providerIterator.hasNext()) {
                classificationProviders.add(providerIterator.next());
            }
            providers = classificationProviders;
        }
        return providers;
    }
}
