// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Mon Sep 14 01:17:22 JST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  UserController_11: controllers.api.UserController,
  // @LINE:16
  BodyPartController_1: controllers.api.BodyPartController,
  // @LINE:23
  TargetController_5: controllers.api.TargetController,
  // @LINE:30
  CategoryController_9: controllers.api.CategoryController,
  // @LINE:33
  ListTrainingMenuController_0: controllers.ListTrainingMenuController,
  // @LINE:34
  CreateTrainingMenuController_8: controllers.CreateTrainingMenuController,
  // @LINE:35
  CreateLiftTypeController_6: controllers.CreateLiftTypeController,
  // @LINE:36
  DeleteLiftTypeController_4: controllers.DeleteLiftTypeController,
  // @LINE:37
  DeleteTrainingMenuController_2: controllers.DeleteTrainingMenuController,
  // @LINE:38
  ShareLiftTypeController_10: controllers.ShareLiftTypeController,
  // @LINE:39
  RegisterLiftTypesToTrainingMenuController_3: controllers.RegisterLiftTypesToTrainingMenuController,
  // @LINE:40
  DeleteLiftTypesFromTrainingMenuController_7: controllers.DeleteLiftTypesFromTrainingMenuController,
  // @LINE:73
  Assets_12: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    UserController_11: controllers.api.UserController,
    // @LINE:16
    BodyPartController_1: controllers.api.BodyPartController,
    // @LINE:23
    TargetController_5: controllers.api.TargetController,
    // @LINE:30
    CategoryController_9: controllers.api.CategoryController,
    // @LINE:33
    ListTrainingMenuController_0: controllers.ListTrainingMenuController,
    // @LINE:34
    CreateTrainingMenuController_8: controllers.CreateTrainingMenuController,
    // @LINE:35
    CreateLiftTypeController_6: controllers.CreateLiftTypeController,
    // @LINE:36
    DeleteLiftTypeController_4: controllers.DeleteLiftTypeController,
    // @LINE:37
    DeleteTrainingMenuController_2: controllers.DeleteTrainingMenuController,
    // @LINE:38
    ShareLiftTypeController_10: controllers.ShareLiftTypeController,
    // @LINE:39
    RegisterLiftTypesToTrainingMenuController_3: controllers.RegisterLiftTypesToTrainingMenuController,
    // @LINE:40
    DeleteLiftTypesFromTrainingMenuController_7: controllers.DeleteLiftTypesFromTrainingMenuController,
    // @LINE:73
    Assets_12: controllers.Assets
  ) = this(errorHandler, UserController_11, BodyPartController_1, TargetController_5, CategoryController_9, ListTrainingMenuController_0, CreateTrainingMenuController_8, CreateLiftTypeController_6, DeleteLiftTypeController_4, DeleteTrainingMenuController_2, ShareLiftTypeController_10, RegisterLiftTypesToTrainingMenuController_3, DeleteLiftTypesFromTrainingMenuController_7, Assets_12, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_11, BodyPartController_1, TargetController_5, CategoryController_9, ListTrainingMenuController_0, CreateTrainingMenuController_8, CreateLiftTypeController_6, DeleteLiftTypeController_4, DeleteTrainingMenuController_2, ShareLiftTypeController_10, RegisterLiftTypesToTrainingMenuController_3, DeleteLiftTypesFromTrainingMenuController_7, Assets_12, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.api.UserController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.api.UserController.store"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """user_id<[^/]+>""", """controllers.api.UserController.show(user_id:Int)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.api.UserController.update"""),
    ("""DELETE""", this.prefix, """controllers.api.UserController.delete(user_id:Option[Int])"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """body_parts""", """controllers.api.BodyPartController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """body_parts""", """controllers.api.BodyPartController.store"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """body_parts/""" + "$" + """body_part_id<[^/]+>""", """controllers.api.BodyPartController.show(body_part_id:Int)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """body_parts/""" + "$" + """body_part_id<[^/]+>""", """controllers.api.BodyPartController.update(body_part_id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """targets""", """controllers.api.TargetController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """targets""", """controllers.api.TargetController.store"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """targets/""" + "$" + """target_id<[^/]+>""", """controllers.api.TargetController.show(target_id:Int)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """targets/""" + "$" + """target_id<[^/]+>""", """controllers.api.TargetController.update(target_id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.api.CategoryController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories/""" + "$" + """category_id<[^/]+>""", """controllers.api.CategoryController.show(category_id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """training_menu""", """controllers.ListTrainingMenuController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """training_menu""", """controllers.CreateTrainingMenuController.store"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lift_types""", """controllers.CreateLiftTypeController.store"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lift_types/""" + "$" + """lift_type_id<[^/]+>""", """controllers.DeleteLiftTypeController.delete(lift_type_id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """training_menu/""" + "$" + """training_menu_id<[^/]+>""", """controllers.DeleteTrainingMenuController.delete(training_menu_id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lift_types/""" + "$" + """lift_type_id<[^/]+>/share""", """controllers.ShareLiftTypeController.share(lift_type_id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """training_menu/lift_types""", """controllers.RegisterLiftTypesToTrainingMenuController.registerLiftTypesToTrainingMenu"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """training_menu/""" + "$" + """training_menu_id<[^/]+>/lift_types/delete""", """controllers.DeleteLiftTypesFromTrainingMenuController.deleteLiftTypesFromTrainingMenu(training_menu_id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_api_UserController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_api_UserController_index0_invoker = createInvoker(
    UserController_11.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.UserController",
      "index",
      Nil,
      "GET",
      this.prefix + """users""",
      """ User""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_api_UserController_store1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_api_UserController_store1_invoker = createInvoker(
    UserController_11.store,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.UserController",
      "store",
      Nil,
      "POST",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_api_UserController_show2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("user_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_UserController_show2_invoker = createInvoker(
    UserController_11.show(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.UserController",
      "show",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """users/""" + "$" + """user_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_api_UserController_update3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_api_UserController_update3_invoker = createInvoker(
    UserController_11.update,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.UserController",
      "update",
      Nil,
      "PUT",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_api_UserController_delete4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_api_UserController_delete4_invoker = createInvoker(
    UserController_11.delete(fakeValue[Option[Int]]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.UserController",
      "delete",
      Seq(classOf[Option[Int]]),
      "DELETE",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_api_BodyPartController_index5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("body_parts")))
  )
  private[this] lazy val controllers_api_BodyPartController_index5_invoker = createInvoker(
    BodyPartController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.BodyPartController",
      "index",
      Nil,
      "GET",
      this.prefix + """body_parts""",
      """ BodyPart""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_api_BodyPartController_store6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("body_parts")))
  )
  private[this] lazy val controllers_api_BodyPartController_store6_invoker = createInvoker(
    BodyPartController_1.store,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.BodyPartController",
      "store",
      Nil,
      "POST",
      this.prefix + """body_parts""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_api_BodyPartController_show7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("body_parts/"), DynamicPart("body_part_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_BodyPartController_show7_invoker = createInvoker(
    BodyPartController_1.show(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.BodyPartController",
      "show",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """body_parts/""" + "$" + """body_part_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_api_BodyPartController_update8_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("body_parts/"), DynamicPart("body_part_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_BodyPartController_update8_invoker = createInvoker(
    BodyPartController_1.update(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.BodyPartController",
      "update",
      Seq(classOf[Int]),
      "PUT",
      this.prefix + """body_parts/""" + "$" + """body_part_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_api_TargetController_index9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("targets")))
  )
  private[this] lazy val controllers_api_TargetController_index9_invoker = createInvoker(
    TargetController_5.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.TargetController",
      "index",
      Nil,
      "GET",
      this.prefix + """targets""",
      """ Target""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_api_TargetController_store10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("targets")))
  )
  private[this] lazy val controllers_api_TargetController_store10_invoker = createInvoker(
    TargetController_5.store,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.TargetController",
      "store",
      Nil,
      "POST",
      this.prefix + """targets""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_api_TargetController_show11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("targets/"), DynamicPart("target_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_TargetController_show11_invoker = createInvoker(
    TargetController_5.show(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.TargetController",
      "show",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """targets/""" + "$" + """target_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_api_TargetController_update12_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("targets/"), DynamicPart("target_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_TargetController_update12_invoker = createInvoker(
    TargetController_5.update(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.TargetController",
      "update",
      Seq(classOf[Int]),
      "PUT",
      this.prefix + """targets/""" + "$" + """target_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_api_CategoryController_index13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_api_CategoryController_index13_invoker = createInvoker(
    CategoryController_9.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.CategoryController",
      "index",
      Nil,
      "GET",
      this.prefix + """categories""",
      """ Category""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_api_CategoryController_show14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("category_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_CategoryController_show14_invoker = createInvoker(
    CategoryController_9.show(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.CategoryController",
      "show",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """categories/""" + "$" + """category_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_ListTrainingMenuController_index15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("training_menu")))
  )
  private[this] lazy val controllers_ListTrainingMenuController_index15_invoker = createInvoker(
    ListTrainingMenuController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ListTrainingMenuController",
      "index",
      Nil,
      "GET",
      this.prefix + """training_menu""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_CreateTrainingMenuController_store16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("training_menu")))
  )
  private[this] lazy val controllers_CreateTrainingMenuController_store16_invoker = createInvoker(
    CreateTrainingMenuController_8.store,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CreateTrainingMenuController",
      "store",
      Nil,
      "POST",
      this.prefix + """training_menu""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_CreateLiftTypeController_store17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lift_types")))
  )
  private[this] lazy val controllers_CreateLiftTypeController_store17_invoker = createInvoker(
    CreateLiftTypeController_6.store,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CreateLiftTypeController",
      "store",
      Nil,
      "POST",
      this.prefix + """lift_types""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_DeleteLiftTypeController_delete18_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lift_types/"), DynamicPart("lift_type_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeleteLiftTypeController_delete18_invoker = createInvoker(
    DeleteLiftTypeController_4.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeleteLiftTypeController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """lift_types/""" + "$" + """lift_type_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_DeleteTrainingMenuController_delete19_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("training_menu/"), DynamicPart("training_menu_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeleteTrainingMenuController_delete19_invoker = createInvoker(
    DeleteTrainingMenuController_2.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeleteTrainingMenuController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """training_menu/""" + "$" + """training_menu_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_ShareLiftTypeController_share20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lift_types/"), DynamicPart("lift_type_id", """[^/]+""",true), StaticPart("/share")))
  )
  private[this] lazy val controllers_ShareLiftTypeController_share20_invoker = createInvoker(
    ShareLiftTypeController_10.share(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShareLiftTypeController",
      "share",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """lift_types/""" + "$" + """lift_type_id<[^/]+>/share""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_RegisterLiftTypesToTrainingMenuController_registerLiftTypesToTrainingMenu21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("training_menu/lift_types")))
  )
  private[this] lazy val controllers_RegisterLiftTypesToTrainingMenuController_registerLiftTypesToTrainingMenu21_invoker = createInvoker(
    RegisterLiftTypesToTrainingMenuController_3.registerLiftTypesToTrainingMenu,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RegisterLiftTypesToTrainingMenuController",
      "registerLiftTypesToTrainingMenu",
      Nil,
      "POST",
      this.prefix + """training_menu/lift_types""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_DeleteLiftTypesFromTrainingMenuController_deleteLiftTypesFromTrainingMenu22_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("training_menu/"), DynamicPart("training_menu_id", """[^/]+""",true), StaticPart("/lift_types/delete")))
  )
  private[this] lazy val controllers_DeleteLiftTypesFromTrainingMenuController_deleteLiftTypesFromTrainingMenu22_invoker = createInvoker(
    DeleteLiftTypesFromTrainingMenuController_7.deleteLiftTypesFromTrainingMenu(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeleteLiftTypesFromTrainingMenuController",
      "deleteLiftTypesFromTrainingMenu",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """training_menu/""" + "$" + """training_menu_id<[^/]+>/lift_types/delete""",
      """""",
      Seq()
    )
  )

  // @LINE:73
  private[this] lazy val controllers_Assets_versioned23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned23_invoker = createInvoker(
    Assets_12.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_api_UserController_index0_route(params@_) =>
      call { 
        controllers_api_UserController_index0_invoker.call(UserController_11.index)
      }
  
    // @LINE:3
    case controllers_api_UserController_store1_route(params@_) =>
      call { 
        controllers_api_UserController_store1_invoker.call(UserController_11.store)
      }
  
    // @LINE:4
    case controllers_api_UserController_show2_route(params@_) =>
      call(params.fromPath[Int]("user_id", None)) { (user_id) =>
        controllers_api_UserController_show2_invoker.call(UserController_11.show(user_id))
      }
  
    // @LINE:5
    case controllers_api_UserController_update3_route(params@_) =>
      call { 
        controllers_api_UserController_update3_invoker.call(UserController_11.update)
      }
  
    // @LINE:6
    case controllers_api_UserController_delete4_route(params@_) =>
      call(params.fromQuery[Option[Int]]("user_id", None)) { (user_id) =>
        controllers_api_UserController_delete4_invoker.call(UserController_11.delete(user_id))
      }
  
    // @LINE:16
    case controllers_api_BodyPartController_index5_route(params@_) =>
      call { 
        controllers_api_BodyPartController_index5_invoker.call(BodyPartController_1.index)
      }
  
    // @LINE:17
    case controllers_api_BodyPartController_store6_route(params@_) =>
      call { 
        controllers_api_BodyPartController_store6_invoker.call(BodyPartController_1.store)
      }
  
    // @LINE:18
    case controllers_api_BodyPartController_show7_route(params@_) =>
      call(params.fromPath[Int]("body_part_id", None)) { (body_part_id) =>
        controllers_api_BodyPartController_show7_invoker.call(BodyPartController_1.show(body_part_id))
      }
  
    // @LINE:19
    case controllers_api_BodyPartController_update8_route(params@_) =>
      call(params.fromPath[Int]("body_part_id", None)) { (body_part_id) =>
        controllers_api_BodyPartController_update8_invoker.call(BodyPartController_1.update(body_part_id))
      }
  
    // @LINE:23
    case controllers_api_TargetController_index9_route(params@_) =>
      call { 
        controllers_api_TargetController_index9_invoker.call(TargetController_5.index)
      }
  
    // @LINE:24
    case controllers_api_TargetController_store10_route(params@_) =>
      call { 
        controllers_api_TargetController_store10_invoker.call(TargetController_5.store)
      }
  
    // @LINE:25
    case controllers_api_TargetController_show11_route(params@_) =>
      call(params.fromPath[Int]("target_id", None)) { (target_id) =>
        controllers_api_TargetController_show11_invoker.call(TargetController_5.show(target_id))
      }
  
    // @LINE:26
    case controllers_api_TargetController_update12_route(params@_) =>
      call(params.fromPath[Int]("target_id", None)) { (target_id) =>
        controllers_api_TargetController_update12_invoker.call(TargetController_5.update(target_id))
      }
  
    // @LINE:30
    case controllers_api_CategoryController_index13_route(params@_) =>
      call { 
        controllers_api_CategoryController_index13_invoker.call(CategoryController_9.index)
      }
  
    // @LINE:31
    case controllers_api_CategoryController_show14_route(params@_) =>
      call(params.fromPath[Int]("category_id", None)) { (category_id) =>
        controllers_api_CategoryController_show14_invoker.call(CategoryController_9.show(category_id))
      }
  
    // @LINE:33
    case controllers_ListTrainingMenuController_index15_route(params@_) =>
      call { 
        controllers_ListTrainingMenuController_index15_invoker.call(ListTrainingMenuController_0.index)
      }
  
    // @LINE:34
    case controllers_CreateTrainingMenuController_store16_route(params@_) =>
      call { 
        controllers_CreateTrainingMenuController_store16_invoker.call(CreateTrainingMenuController_8.store)
      }
  
    // @LINE:35
    case controllers_CreateLiftTypeController_store17_route(params@_) =>
      call { 
        controllers_CreateLiftTypeController_store17_invoker.call(CreateLiftTypeController_6.store)
      }
  
    // @LINE:36
    case controllers_DeleteLiftTypeController_delete18_route(params@_) =>
      call(params.fromPath[Int]("lift_type_id", None)) { (lift_type_id) =>
        controllers_DeleteLiftTypeController_delete18_invoker.call(DeleteLiftTypeController_4.delete(lift_type_id))
      }
  
    // @LINE:37
    case controllers_DeleteTrainingMenuController_delete19_route(params@_) =>
      call(params.fromPath[Int]("training_menu_id", None)) { (training_menu_id) =>
        controllers_DeleteTrainingMenuController_delete19_invoker.call(DeleteTrainingMenuController_2.delete(training_menu_id))
      }
  
    // @LINE:38
    case controllers_ShareLiftTypeController_share20_route(params@_) =>
      call(params.fromPath[Int]("lift_type_id", None)) { (lift_type_id) =>
        controllers_ShareLiftTypeController_share20_invoker.call(ShareLiftTypeController_10.share(lift_type_id))
      }
  
    // @LINE:39
    case controllers_RegisterLiftTypesToTrainingMenuController_registerLiftTypesToTrainingMenu21_route(params@_) =>
      call { 
        controllers_RegisterLiftTypesToTrainingMenuController_registerLiftTypesToTrainingMenu21_invoker.call(RegisterLiftTypesToTrainingMenuController_3.registerLiftTypesToTrainingMenu)
      }
  
    // @LINE:40
    case controllers_DeleteLiftTypesFromTrainingMenuController_deleteLiftTypesFromTrainingMenu22_route(params@_) =>
      call(params.fromPath[Int]("training_menu_id", None)) { (training_menu_id) =>
        controllers_DeleteLiftTypesFromTrainingMenuController_deleteLiftTypesFromTrainingMenu22_invoker.call(DeleteLiftTypesFromTrainingMenuController_7.deleteLiftTypesFromTrainingMenu(training_menu_id))
      }
  
    // @LINE:73
    case controllers_Assets_versioned23_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned23_invoker.call(Assets_12.versioned(path, file))
      }
  }
}
