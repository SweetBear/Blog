package com.fh.controller.blog.article;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.service.erp.goods.GoodsManager;
import com.fh.util.PageData;


/**
 * 
 * @author User
 *
 */
@Controller
@RequestMapping(value="/myArticle")
public class ArticleController extends BaseController {
    
	@Resource(name="goodsService")
	private GoodsManager goodsService;
	
	 /**商品详情页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/articleList")
	public ModelAndView goView()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = goodsService.findByIdToCha(pd);					//根据ID读取
		mv.setViewName("blog/article/article_list");
		mv.addObject("pd", pd);
		return mv;
	}
	

	
}
