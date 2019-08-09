//GOOGLE AUTH SING IN

List<AuthUI.IdpConfig> providers = Arrays.asList(
        new AuthUI.IdpConfig.EmailBuilder().build(),
        new AuthUI.IdpConfig.PhoneBuilder().build(),
        new AuthUI.IdpConfig.GoogleBuilder().build(),
        new AuthUI.IdpConfig.FacebookBuilder().build(),
        new AuthUI.IdpConfig.TwitterBuilder().build());

//Launcher intent
startActivityForResult(
        AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
        RC_SIGN_IN);
        
        //OnActivityResult open when Auht is succesful
        @Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == RC_SIGN_IN) {
        IdpResponse response = IdpResponse.fromResultIntent(data);

        if (resultCode == RESULT_OK) {
            // Successfully signed in
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            // ...
        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
        }
    }
}


//Email sign In
ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
        .setAndroidPackageName(/* yourPackageName= */ ..., /* installIfNotAvailable= */ true,
        /* minimumVersion= */ null)
        .setHandleCodeInApp(true) // This must be set to true
        .setUrl("https://google.com") // This URL needs to be whitelisted
        .build();

startActivityForResult(
        AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.EmailBuilder().enableEmailLinkSignIn()
                        .setActionCodeSettings(actionCodeSettings).build())
                .build(),
        RC_SIGN_IN);

        if (AuthUI.canHandleIntent(getIntent())) {
    if (getIntent().getExtras() == null) {
            return;
        }
        String link = getIntent().getExtras().getString(ExtraConstants.EMAIL_LINK_SIGN_IN);
        if (link != null) {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setEmailLink(link)
                            .setAvailableProviders(getAvailableProviders())
                            .build(),
                    RC_SIGN_IN);
        }
}
