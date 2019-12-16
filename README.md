# College Applicant Classifier Application

Classifier used to classify College Applicant as:
* Instant Rejected.
* Instant Accepted.
* Further Review.

Classifier consist of API and IMPL artifacts.
* API contains all base models and services interfaces used for applicant classification.
* IMPL contains all implementaions of API.

Classifier implementation is using ClassificiationProviders as source of Classifications.
ClassificationProviders contains Classifications as rules for Applicant classification.
Each rule (classification) will validate Applicant to be Accepted or Rejected or Not Qualified.
ClassificationProvider also contains type of Classifications:
* Rejection.
* Acceptance.

Applicant classification examples:
* If Applicant is qualified as Accepted by all Classifications from ClassificationProviders of type Acceptance then it will be classified as _Instant Accepted_.
* If Applicant is qualified as Rejected by at least one Classification from ClassificationProvider of type Rejection it will be classified as _Instant Rejected_.
* If Applicant is not qualified as Rejected by any of Classifications from providers of type Rejection  
and not qualified as Accepted by all Classifications by provider of type Acceptance, then Applicant will be classified as _Further Review_.

To supply custom Classifications to Classifier:
1. Create provider that implements ClassificationProvider.
2. Add custom Classifications to created provider.
3. Register provider as service in recources/META-INF/services.
