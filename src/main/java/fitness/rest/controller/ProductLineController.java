package fitness.rest.controller;

import com.google.common.collect.Lists;
import fitness.domain.dto.ProductLineDTO;
import fitness.rest.model.ProductLineModel;
import fitness.rest.model.ProductLineResponseModel;
import fitness.service.business.ProductLineService;
import fitness.service.business.ProductService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


/**
 * Created by Anton_Kramarev on 6/19/2017.
 */

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE, value = "/api/v1/products/lines")
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;
    @Autowired
    private ProductService productService;
    @Autowired
    private DozerBeanMapper mapper;

    @GetMapping(value = "/{productLineId}")
    @ResponseBody
    public ResponseEntity<ProductLineResponseModel> getProductLine(@PathVariable Long productLineId) {
        ProductLineDTO productLineDTO = this.productLineService.getProductLine(productLineId);
        ProductLineResponseModel response = mapper.map(productLineDTO, ProductLineResponseModel.class);
        response.add(createLinks(productLineDTO, response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{productLineId}")
    @ResponseBody
    public ResponseEntity deleteProductLine(@PathVariable Long productLineId) {
        productLineService.deleteProductLine(productLineId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ProductLineResponseModel> createProductLine(@RequestBody ProductLineModel request) {
        ProductLineDTO line = mapper.map(request, ProductLineDTO.class);
        line.setProduct(productService.getProduct(request.getProductId()));
        ProductLineDTO createdLine = this.productLineService.createProductLine(line);
        ProductLineResponseModel response = mapper.map(createdLine, ProductLineResponseModel.class);
        response.add(createLinks(createdLine, response));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private static List<Link> createLinks(ProductLineDTO productLineDTO, ProductLineResponseModel model) {
        return Lists.newArrayList(
                linkTo(methodOn(ProductLineController.class).getProductLine(model.getLineId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).getProduct(productLineDTO.getProduct().getId())).withRel("product")
        );
    }

}
