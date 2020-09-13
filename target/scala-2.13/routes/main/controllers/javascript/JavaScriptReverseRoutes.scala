// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Mon Sep 14 01:17:22 JST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:33
package controllers.javascript {

  // @LINE:73
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:73
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:38
  class ReverseShareLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def share: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShareLiftTypeController.share",
      """
        function(lift_type_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("lift_type_id", lift_type_id0)) + "/share"})
        }
      """
    )
  
  }

  // @LINE:39
  class ReverseRegisterLiftTypesToTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def registerLiftTypesToTrainingMenu: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterLiftTypesToTrainingMenuController.registerLiftTypesToTrainingMenu",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "training_menu/lift_types"})
        }
      """
    )
  
  }

  // @LINE:40
  class ReverseDeleteLiftTypesFromTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:40
    def deleteLiftTypesFromTrainingMenu: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeleteLiftTypesFromTrainingMenuController.deleteLiftTypesFromTrainingMenu",
      """
        function(training_menu_id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "training_menu/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("training_menu_id", training_menu_id0)) + "/lift_types/delete"})
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
