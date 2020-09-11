// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Sat Sep 12 01:21:18 JST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:9
package controllers.javascript {

  // @LINE:71
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:71
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:37
  class ReverseDeleteTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeleteTrainingMenuController.delete",
      """
        function(training_menu_id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "training_menu/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("training_menu_id", training_menu_id0))})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseListLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ListLiftTypeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types"})
        }
      """
    )
  
  }

  // @LINE:35
  class ReverseCreateLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CreateLiftTypeController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types"})
        }
      """
    )
  
  }

  // @LINE:33
  class ReverseListTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ListTrainingMenuController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "training_menu"})
        }
      """
    )
  
  }

  // @LINE:36
  class ReverseDeleteLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeleteLiftTypeController.delete",
      """
        function(lift_type_id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("lift_type_id", lift_type_id0))})
        }
      """
    )
  
  }

  // @LINE:38
  class ReversePublishTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def publish: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublishTrainingMenuController.publish",
      """
        function(training_menu_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "training_menu/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("training_menu_id", training_menu_id0)) + "/pub"})
        }
      """
    )
  
  }

  // @LINE:34
  class ReverseCreateTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CreateTrainingMenuController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "training_menu"})
        }
      """
    )
  
  }


}
