// @GENERATOR:play-routes-compiler
// @SOURCE:/root/muscle-training_manager/conf/routes
// @DATE:Thu Sep 03 21:34:03 JST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  UserController_7: controllers.api.UserController,
  // @LINE:9
  ListLiftTypeController_2: controllers.ListLiftTypeController,
  // @LINE:10
  LiftTypeController_1: controllers.api.LiftTypeController,
  // @LINE:16
  BodyPartController_3: controllers.api.BodyPartController,
  // @LINE:23
  TargetController_4: controllers.api.TargetController,
  // @LINE:30
  CategoryController_6: controllers.api.CategoryController,
  // @LINE:33
  ListTrainingMenuController_0: controllers.ListTrainingMenuController,
  // @LINE:34
  CreateTrainingMenuController_5: controllers.CreateTrainingMenuController,
  // @LINE:68
  Assets_8: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    UserController_7: controllers.api.UserController,
    // @LINE:9
    ListLiftTypeController_2: controllers.ListLiftTypeController,
    // @LINE:10
    LiftTypeController_1: controllers.api.LiftTypeController,
    // @LINE:16
    BodyPartController_3: controllers.api.BodyPartController,
    // @LINE:23
    TargetController_4: controllers.api.TargetController,
    // @LINE:30
    CategoryController_6: controllers.api.CategoryController,
    // @LINE:33
    ListTrainingMenuController_0: controllers.ListTrainingMenuController,
    // @LINE:34
    CreateTrainingMenuController_5: controllers.CreateTrainingMenuController,
    // @LINE:68
    Assets_8: controllers.Assets
  ) = this(errorHandler, UserController_7, ListLiftTypeController_2, LiftTypeController_1, BodyPartController_3, TargetController_4, CategoryController_6, ListTrainingMenuController_0, CreateTrainingMenuController_5, Assets_8, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_7, ListLiftTypeController_2, LiftTypeController_1, BodyPartController_3, TargetController_4, CategoryController_6, ListTrainingMenuController_0, CreateTrainingMenuController_5, Assets_8, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lift_types""", """controllers.ListLiftTypeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lift_types""", """controllers.api.LiftTypeController.store"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lift_types/""" + "$" + """lift_type_id<[^/]+>""", """controllers.api.LiftTypeController.show(lift_type_id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lift_types/""" + "$" + """lift_type_id<[^/]+>""", """controllers.api.LiftTypeController.update(lift_type_id:Int)"""),
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
    UserController_7.index,
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
    UserController_7.store,
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
    UserController_7.show(fakeValue[Int]),
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
    UserController_7.update,
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
    UserController_7.delete(fakeValue[Option[Int]]),
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

  // @LINE:9
  private[this] lazy val controllers_ListLiftTypeController_index5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lift_types")))
  )
  private[this] lazy val controllers_ListLiftTypeController_index5_invoker = createInvoker(
    ListLiftTypeController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ListLiftTypeController",
      "index",
      Nil,
      "GET",
      this.prefix + """lift_types""",
      """ Lift""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_api_LiftTypeController_store6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lift_types")))
  )
  private[this] lazy val controllers_api_LiftTypeController_store6_invoker = createInvoker(
    LiftTypeController_1.store,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.LiftTypeController",
      "store",
      Nil,
      "POST",
      this.prefix + """lift_types""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_api_LiftTypeController_show7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lift_types/"), DynamicPart("lift_type_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_LiftTypeController_show7_invoker = createInvoker(
    LiftTypeController_1.show(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.LiftTypeController",
      "show",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """lift_types/""" + "$" + """lift_type_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_api_LiftTypeController_update8_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lift_types/"), DynamicPart("lift_type_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_LiftTypeController_update8_invoker = createInvoker(
    LiftTypeController_1.update(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.LiftTypeController",
      "update",
      Seq(classOf[Int]),
      "PATCH",
      this.prefix + """lift_types/""" + "$" + """lift_type_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_api_BodyPartController_index9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("body_parts")))
  )
  private[this] lazy val controllers_api_BodyPartController_index9_invoker = createInvoker(
    BodyPartController_3.index,
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
  private[this] lazy val controllers_api_BodyPartController_store10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("body_parts")))
  )
  private[this] lazy val controllers_api_BodyPartController_store10_invoker = createInvoker(
    BodyPartController_3.store,
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
  private[this] lazy val controllers_api_BodyPartController_show11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("body_parts/"), DynamicPart("body_part_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_BodyPartController_show11_invoker = createInvoker(
    BodyPartController_3.show(fakeValue[Int]),
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
  private[this] lazy val controllers_api_BodyPartController_update12_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("body_parts/"), DynamicPart("body_part_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_BodyPartController_update12_invoker = createInvoker(
    BodyPartController_3.update(fakeValue[Int]),
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
  private[this] lazy val controllers_api_TargetController_index13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("targets")))
  )
  private[this] lazy val controllers_api_TargetController_index13_invoker = createInvoker(
    TargetController_4.index,
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
  private[this] lazy val controllers_api_TargetController_store14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("targets")))
  )
  private[this] lazy val controllers_api_TargetController_store14_invoker = createInvoker(
    TargetController_4.store,
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
  private[this] lazy val controllers_api_TargetController_show15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("targets/"), DynamicPart("target_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_TargetController_show15_invoker = createInvoker(
    TargetController_4.show(fakeValue[Int]),
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
  private[this] lazy val controllers_api_TargetController_update16_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("targets/"), DynamicPart("target_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_TargetController_update16_invoker = createInvoker(
    TargetController_4.update(fakeValue[Int]),
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
  private[this] lazy val controllers_api_CategoryController_index17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_api_CategoryController_index17_invoker = createInvoker(
    CategoryController_6.index,
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
  private[this] lazy val controllers_api_CategoryController_show18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("category_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_CategoryController_show18_invoker = createInvoker(
    CategoryController_6.show(fakeValue[Int]),
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
  private[this] lazy val controllers_ListTrainingMenuController_index19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("training_menu")))
  )
  private[this] lazy val controllers_ListTrainingMenuController_index19_invoker = createInvoker(
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
  private[this] lazy val controllers_CreateTrainingMenuController_store20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("training_menu")))
  )
  private[this] lazy val controllers_CreateTrainingMenuController_store20_invoker = createInvoker(
    CreateTrainingMenuController_5.store,
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

  // @LINE:68
  private[this] lazy val controllers_Assets_versioned21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned21_invoker = createInvoker(
    Assets_8.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_api_UserController_index0_invoker.call(UserController_7.index)
      }
  
    // @LINE:3
    case controllers_api_UserController_store1_route(params@_) =>
      call { 
        controllers_api_UserController_store1_invoker.call(UserController_7.store)
      }
  
    // @LINE:4
    case controllers_api_UserController_show2_route(params@_) =>
      call(params.fromPath[Int]("user_id", None)) { (user_id) =>
        controllers_api_UserController_show2_invoker.call(UserController_7.show(user_id))
      }
  
    // @LINE:5
    case controllers_api_UserController_update3_route(params@_) =>
      call { 
        controllers_api_UserController_update3_invoker.call(UserController_7.update)
      }
  
    // @LINE:6
    case controllers_api_UserController_delete4_route(params@_) =>
      call(params.fromQuery[Option[Int]]("user_id", None)) { (user_id) =>
        controllers_api_UserController_delete4_invoker.call(UserController_7.delete(user_id))
      }
  
    // @LINE:9
    case controllers_ListLiftTypeController_index5_route(params@_) =>
      call { 
        controllers_ListLiftTypeController_index5_invoker.call(ListLiftTypeController_2.index)
      }
  
    // @LINE:10
    case controllers_api_LiftTypeController_store6_route(params@_) =>
      call { 
        controllers_api_LiftTypeController_store6_invoker.call(LiftTypeController_1.store)
      }
  
    // @LINE:11
    case controllers_api_LiftTypeController_show7_route(params@_) =>
      call(params.fromPath[Int]("lift_type_id", None)) { (lift_type_id) =>
        controllers_api_LiftTypeController_show7_invoker.call(LiftTypeController_1.show(lift_type_id))
      }
  
    // @LINE:12
    case controllers_api_LiftTypeController_update8_route(params@_) =>
      call(params.fromPath[Int]("lift_type_id", None)) { (lift_type_id) =>
        controllers_api_LiftTypeController_update8_invoker.call(LiftTypeController_1.update(lift_type_id))
      }
  
    // @LINE:16
    case controllers_api_BodyPartController_index9_route(params@_) =>
      call { 
        controllers_api_BodyPartController_index9_invoker.call(BodyPartController_3.index)
      }
  
    // @LINE:17
    case controllers_api_BodyPartController_store10_route(params@_) =>
      call { 
        controllers_api_BodyPartController_store10_invoker.call(BodyPartController_3.store)
      }
  
    // @LINE:18
    case controllers_api_BodyPartController_show11_route(params@_) =>
      call(params.fromPath[Int]("body_part_id", None)) { (body_part_id) =>
        controllers_api_BodyPartController_show11_invoker.call(BodyPartController_3.show(body_part_id))
      }
  
    // @LINE:19
    case controllers_api_BodyPartController_update12_route(params@_) =>
      call(params.fromPath[Int]("body_part_id", None)) { (body_part_id) =>
        controllers_api_BodyPartController_update12_invoker.call(BodyPartController_3.update(body_part_id))
      }
  
    // @LINE:23
    case controllers_api_TargetController_index13_route(params@_) =>
      call { 
        controllers_api_TargetController_index13_invoker.call(TargetController_4.index)
      }
  
    // @LINE:24
    case controllers_api_TargetController_store14_route(params@_) =>
      call { 
        controllers_api_TargetController_store14_invoker.call(TargetController_4.store)
      }
  
    // @LINE:25
    case controllers_api_TargetController_show15_route(params@_) =>
      call(params.fromPath[Int]("target_id", None)) { (target_id) =>
        controllers_api_TargetController_show15_invoker.call(TargetController_4.show(target_id))
      }
  
    // @LINE:26
    case controllers_api_TargetController_update16_route(params@_) =>
      call(params.fromPath[Int]("target_id", None)) { (target_id) =>
        controllers_api_TargetController_update16_invoker.call(TargetController_4.update(target_id))
      }
  
    // @LINE:30
    case controllers_api_CategoryController_index17_route(params@_) =>
      call { 
        controllers_api_CategoryController_index17_invoker.call(CategoryController_6.index)
      }
  
    // @LINE:31
    case controllers_api_CategoryController_show18_route(params@_) =>
      call(params.fromPath[Int]("category_id", None)) { (category_id) =>
        controllers_api_CategoryController_show18_invoker.call(CategoryController_6.show(category_id))
      }
  
    // @LINE:33
    case controllers_ListTrainingMenuController_index19_route(params@_) =>
      call { 
        controllers_ListTrainingMenuController_index19_invoker.call(ListTrainingMenuController_0.index)
      }
  
    // @LINE:34
    case controllers_CreateTrainingMenuController_store20_route(params@_) =>
      call { 
        controllers_CreateTrainingMenuController_store20_invoker.call(CreateTrainingMenuController_5.store)
      }
  
    // @LINE:68
    case controllers_Assets_versioned21_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned21_invoker.call(Assets_8.versioned(path, file))
      }
  }
}
