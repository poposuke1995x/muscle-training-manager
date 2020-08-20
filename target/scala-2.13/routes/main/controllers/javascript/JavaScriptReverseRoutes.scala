// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Thu Aug 20 00:50:15 JST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.javascript {

  // @LINE:65
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:65
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseTargetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TargetController.show",
      """
        function(target_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "targets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("target_id", target_id0))})
        }
      """
    )
  
    // @LINE:24
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TargetController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "targets"})
        }
      """
    )
  
    // @LINE:23
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TargetController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "targets"})
        }
      """
    )
  
    // @LINE:26
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TargetController.update",
      """
        function(target_id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "targets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("target_id", target_id0))})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LiftTypeController.show",
      """
        function(lift_type_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_type/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("lift_type_id", lift_type_id0))})
        }
      """
    )
  
    // @LINE:10
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LiftTypeController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_type"})
        }
      """
    )
  
    // @LINE:9
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LiftTypeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_type"})
        }
      """
    )
  
    // @LINE:12
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LiftTypeController.update",
      """
        function(lift_type_id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_type/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("lift_type_id", lift_type_id0))})
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
      "controllers.CategoryController.show",
      """
        function(category_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "categories/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("category_id", category_id0))})
        }
      """
    )
  
    // @LINE:30
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoryController.index",
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
      "controllers.UserController.show",
      """
        function(user_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("user_id", user_id0))})
        }
      """
    )
  
    // @LINE:6
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.delete",
      """
        function(user_id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + """" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].javascriptUnbind + """)("user_id", user_id0)])})
        }
      """
    )
  
    // @LINE:3
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:5
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.update",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.index",
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
      "controllers.BodyPartController.show",
      """
        function(body_part_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "body_parts/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("body_part_id", body_part_id0))})
        }
      """
    )
  
    // @LINE:17
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BodyPartController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "body_parts"})
        }
      """
    )
  
    // @LINE:16
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BodyPartController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "body_parts"})
        }
      """
    )
  
    // @LINE:19
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BodyPartController.update",
      """
        function(body_part_id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "body_parts/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("body_part_id", body_part_id0))})
        }
      """
    )
  
  }


}
