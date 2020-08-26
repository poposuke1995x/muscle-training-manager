// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Sat Aug 22 03:46:07 JST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseListLiftTypeController ListLiftTypeController = new controllers.ReverseListLiftTypeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseListLiftTypeController ListLiftTypeController = new controllers.javascript.ReverseListLiftTypeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
