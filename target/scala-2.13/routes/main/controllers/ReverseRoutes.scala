// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Sat Sep 12 01:21:18 JST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:9
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

  // @LINE:9
  class ReverseListLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lift_types")
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

  // @LINE:38
  class ReversePublishTrainingMenuController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def publish(training_menu_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "training_menu/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("training_menu_id", training_menu_id)) + "/pub")
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
