package controllers

import Utils.convertModelToResp
import com.google.inject._
import play.api.mvc._
import usecase.ListCategoryService

import scala.concurrent.ExecutionContext

class ListCategoryController @Inject()
(controllerComponents: ControllerComponents, listCategoryService: ListCategoryService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def index: Action[AnyContent] = Action.async {
    listCategoryService().map { categories => Ok(convertModelToResp(categories)) }
  }
}
