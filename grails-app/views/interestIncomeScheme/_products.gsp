<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<div class="fieldcontain form-group">
    <label class="control-label col-sm-4" for="">Products</label>
    <!-- <div class="col-sm-8"><g:select id="products" name="products" from="${icbs.admin.Product.findAllByProductTypeAndConfigItemStatus(ProductType.get(6),ConfigItemStatus.get(2))}" optionKey="id" optionValue="name" value="${interestIncomeSchemeInstance?.products?.id}" class="many-to-one form-control" multiple="" /></div> -->
    <div class="col-sm-8"><g:select id="products" name="products" from="${icbs.admin.Product.findAll("from Product where product_type_id in (6,7) and config_item_status_id = 2")}" optionKey="id" optionValue="name" value="${interestIncomeSchemeInstance?.products?.id}" class="many-to-one form-control" multiple="" /></div>
</div>