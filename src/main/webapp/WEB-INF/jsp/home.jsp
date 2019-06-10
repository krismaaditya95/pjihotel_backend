<%@ include file = "header.jsp" %>
<%@ include file = "nav.jsp" %>

 <%-- ng-controller="routingCtrl" --%>
<div id="divApp" ng-app = "routingApp">
  <div ng-view>
    
  </div>
</div>

<%@ include file = "footer.jsp" %>
