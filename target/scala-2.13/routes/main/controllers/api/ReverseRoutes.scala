// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Thu Sep 10 20:22:00 JST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.api {

  // @LINE:23
  class ReverseTargetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def show(target_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "targets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("target_id", target_id)))
    }
  
    // @LINE:24
    def store(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "targets")
    }
  
    // @LINE:23
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "targets")
    }
  
    // @LINE:26
    def update(target_id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "targets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("target_id", target_id)))
    }
  
  }

  // @LINE:10
  class ReverseLiftTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def show(lift_type_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lift_types/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("lift_type_id", lift_type_id)))
    }
  
    // @LINE:10
    def store(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "lift_types")
    }
  
    // @LINE:12
    def update(lift_type_id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "lift_types/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("lift_type_id", lift_type_id)))
    }
  
  }

  // @LINE:30
  class ReverseCategoryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def show(category_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("category_id", category_id)))
    }
  
    // @LINE:30
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
  }

  // @LINE:2
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def show(user_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("user_id", user_id)))
    }
  
    // @LINE:6
    def delete(user_id:Option[Int]): Call = {
      
      Call("DELETE", _prefix + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].unbind("user_id", user_id)))))
    }
  
    // @LINE:3
    def store(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:5
    def update(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
  }

  // @LINE:16
  class ReverseBodyPartController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def show(body_part_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "body_parts/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("body_part_id", body_part_id)))
    }
  
    // @LINE:17
    def store(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "body_parts")
    }
  
    // @LINE:16
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "body_parts")
    }
  
    // @LINE:19
    def update(body_part_id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "body_parts/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("body_part_id", body_part_id)))
    }
  
  }


}
