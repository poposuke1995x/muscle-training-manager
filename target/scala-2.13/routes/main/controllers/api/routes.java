// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Sat Aug 22 03:46:07 JST 2020

package controllers.api;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.api.ReverseTargetController TargetController = new controllers.api.ReverseTargetController(RoutesPrefix.byNamePrefix());
  public static final controllers.api.ReverseLiftTypeController LiftTypeController = new controllers.api.ReverseLiftTypeController(RoutesPrefix.byNamePrefix());
  public static final controllers.api.ReverseCategoryController CategoryController = new controllers.api.ReverseCategoryController(RoutesPrefix.byNamePrefix());
  public static final controllers.api.ReverseUserController UserController = new controllers.api.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.api.ReverseBodyPartController BodyPartController = new controllers.api.ReverseBodyPartController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.api.javascript.ReverseTargetController TargetController = new controllers.api.javascript.ReverseTargetController(RoutesPrefix.byNamePrefix());
    public static final controllers.api.javascript.ReverseLiftTypeController LiftTypeController = new controllers.api.javascript.ReverseLiftTypeController(RoutesPrefix.byNamePrefix());
    public static final controllers.api.javascript.ReverseCategoryController CategoryController = new controllers.api.javascript.ReverseCategoryController(RoutesPrefix.byNamePrefix());
    public static final controllers.api.javascript.ReverseUserController UserController = new controllers.api.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.api.javascript.ReverseBodyPartController BodyPartController = new controllers.api.javascript.ReverseBodyPartController(RoutesPrefix.byNamePrefix());
  }

}
