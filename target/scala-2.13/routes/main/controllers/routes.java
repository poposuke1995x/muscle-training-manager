// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Thu Aug 20 00:50:15 JST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTargetController TargetController = new controllers.ReverseTargetController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLiftTypeController LiftTypeController = new controllers.ReverseLiftTypeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCategoryController CategoryController = new controllers.ReverseCategoryController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseBodyPartController BodyPartController = new controllers.ReverseBodyPartController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTargetController TargetController = new controllers.javascript.ReverseTargetController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLiftTypeController LiftTypeController = new controllers.javascript.ReverseLiftTypeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCategoryController CategoryController = new controllers.javascript.ReverseCategoryController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseBodyPartController BodyPartController = new controllers.javascript.ReverseBodyPartController(RoutesPrefix.byNamePrefix());
  }

}
