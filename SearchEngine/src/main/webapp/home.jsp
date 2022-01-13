<div class="container">
<br/>
<a style="cursor:pointer;color:blue;"  href="#!viewElements" ng-click="elementList()">click here</a> to list all the elements from periodic table
<br/>
<a ng-click="openFilter=!openFilter">click here</a> to filter and list the elements based on group and/or period
<br/>
<a >click here</a> to view the element by its atomic number
</div>
<br/>
<div ng-hide="openFilter" ng-init="openFilter=false">

</div>