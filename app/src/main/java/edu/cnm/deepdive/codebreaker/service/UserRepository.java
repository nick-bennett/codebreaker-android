package edu.cnm.deepdive.codebreaker.service;

import android.content.Context;
import edu.cnm.deepdive.codebreaker.model.dto.User;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserRepository {

  private final Context context;
  private final CodebreakerServiceProxy serviceProxy;
  private final GoogleSignInService signInService;

  public UserRepository(Context context) {
    this.context = context;
    serviceProxy = CodebreakerServiceProxy.getInstance();
    signInService = GoogleSignInService.getInstance();
  }

  public Single<User> getProfile() {
    return signInService
        .refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap(serviceProxy::getProfile);
  }

  public Single<User> updateProfile(User user) {
    return signInService
        .refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap((token) -> serviceProxy.updateProfile(user, token));
  }

}
