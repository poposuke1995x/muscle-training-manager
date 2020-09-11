// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Fri Sep 11 23:09:43 JST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.api.javascript {

  // @LINE:23
  class ReverseTargetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.TargetController.show",
      """
        function(target_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "targets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("target_id", target_id0))})
        }
      """
    )
  
    // @LINE:24
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.TargetController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "targets"})
        }
      """
    )
  
    // @LINE:23
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.TargetController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "targets"})
        }
      """
    )
  
    // @LINE:26
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.TargetController.update",
      """
        function(target_id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "targets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("target_id", target_id0))})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.LiftTypeController.show",
      """
        function(lift_type_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("lift_type_id", lift_type_id0))})
        }
      """
    )
  
    // @LINE:10
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.LiftTypeController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types"})
        }
      """
    )
  
    // @LINE:12
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.LiftTypeController.update",
      """
        function(lift_type_id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("lift_type_id", lift_type_id0))})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseCategoryController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.CategoryController.show",
      """
        function(category_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "categories/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("category_id", category_id0))})
        }
      """
    )
  
    // @LINE:30
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.CategoryController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "categories"})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.UserController.show",
      """
        function(user_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("user_id", user_id0))})
        }
      """
    )
  
    // @LINE:6
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.UserController.delete",
      """
        function(user_id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + """" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].javascriptUnbind + """)("user_id", user_id0)])})
        }
      """
    )
  
    // @LINE:3
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.UserController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:5
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.UserController.update",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.UserController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseBodyPartController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.BodyPartController.show",
      """
        function(body_part_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "body_parts/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("body_part_id", body_part_id0))})
        }
      """
    )
  
    // @LINE:17
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.BodyPartController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "body_parts"})
        }
      """
    )
  
    // @LINE:16
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.BodyPartController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "body_parts"})
        }
      """
    )
  
    // @LINE:19
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.api.BodyPartController.update",
      """
        function(body_part_id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "body_parts/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("body_part_id", body_part_id0))})
        }
      """
    )
  
  }


}
