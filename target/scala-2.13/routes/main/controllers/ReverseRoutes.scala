// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Wed Sep 23 00:44:56 JST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:34
package controllers {

  // @LINE:77
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:77
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:42
  class ReverseShareLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def share(lift_type_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lift_types/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("lift_type_id", lift_type_id)) + "/share")
    }
  
  }

  // @LINE:39
  class ReverseRegisterLiftTypesToTrainingMenuController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def registerLiftTypesToTrainingMenu(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "training_menu/lift_types")
    }
  
  }

  // @LINE:38
  class ReverseDeleteLiftTypesFromTrainingMenuController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def deleteLiftTypesFromTrainingMenu(training_menu_id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "training_menu/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("training_menu_id", training_menu_id)) + "/lift_types/delete")
    }
  
  }

  // @LINE:37
  class ReverseDeleteTrainingMenuController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def delete(training_menu_id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "training_menu/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("training_menu_id", training_menu_id)))
    }
  
  }

  // @LINE:40
  class ReverseListLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:40
    def index(body_part_id:Option[Int]): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lift_types" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].unbind("body_part_id", body_part_id)))))
    }
  
  }

  // @LINE:41
  class ReverseCreateLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def store(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "lift_types")
    }
  
  }

  // @LINE:34
  class ReverseListTrainingMenuController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "training_menu")
    }
  
  }

  // @LINE:43
  class ReverseDeleteLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def delete(lift_type_id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "lift_types/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("lift_type_id", lift_type_id)))
    }
  
  }

  // @LINE:44
  class ReverseListUserLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def index(user_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lift_types/users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("user_id", user_id)))
    }
  
  }

  // @LINE:36
  class ReverseListUserTrainingMenuController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def index(user_id:Int, category_id:Option[Int]): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "training_menu/users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("user_id", user_id)) + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].unbind("category_id", category_id)))))
    }
  
  }

  // @LINE:35
  class ReverseCreateTrainingMenuController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def store(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "training_menu")
    }
  
  }


}
