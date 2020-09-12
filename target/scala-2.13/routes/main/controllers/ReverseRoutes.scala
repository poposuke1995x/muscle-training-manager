// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Sun Sep 13 00:08:18 JST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:33
package controllers {

  // @LINE:71
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:71
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:38
  class ReverseShareLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def share(lift_type_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lift_types/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("lift_type_id", lift_type_id)) + "/share")
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

  // @LINE:35
  class ReverseCreateLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def store(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "lift_types")
    }
  
  }

  // @LINE:33
  class ReverseListTrainingMenuController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "training_menu")
    }
  
  }

  // @LINE:36
  class ReverseDeleteLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def delete(lift_type_id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "lift_types/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("lift_type_id", lift_type_id)))
    }
  
  }

  // @LINE:34
  class ReverseCreateTrainingMenuController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def store(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "training_menu")
    }
  
  }


}
