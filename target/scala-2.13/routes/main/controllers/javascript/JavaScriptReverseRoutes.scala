// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Wed Sep 23 00:44:56 JST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:34
package controllers.javascript {

  // @LINE:77
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:77
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:42
  class ReverseShareLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
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

  // @LINE:38
  class ReverseDeleteLiftTypesFromTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
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

  // @LINE:40
  class ReverseListLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:40
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ListLiftTypeController.index",
      """
        function(body_part_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].javascriptUnbind + """)("body_part_id", body_part_id0)])})
        }
      """
    )
  
  }

  // @LINE:41
  class ReverseCreateLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CreateLiftTypeController.store",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types"})
        }
      """
    )
  
  }

  // @LINE:34
  class ReverseListTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ListTrainingMenuController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "training_menu"})
        }
      """
    )
  
  }

  // @LINE:43
  class ReverseDeleteLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeleteLiftTypeController.delete",
      """
        function(lift_type_id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("lift_type_id", lift_type_id0))})
        }
      """
    )
  
  }

  // @LINE:44
  class ReverseListUserLiftTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ListUserLiftTypeController.index",
      """
        function(user_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lift_types/users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("user_id", user_id0))})
        }
      """
    )
  
  }

  // @LINE:36
  class ReverseListUserTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ListUserTrainingMenuController.index",
      """
        function(user_id0,category_id1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "training_menu/users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("user_id", user_id0)) + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].javascriptUnbind + """)("category_id", category_id1)])})
        }
      """
    )
  
  }

  // @LINE:35
  class ReverseCreateTrainingMenuController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
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
