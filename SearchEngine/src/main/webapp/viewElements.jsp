

<div class="container">

<div>length:{{elements.length}}</div>
<table ng-if="displayList">
  <tr ng-repeat="x in elements">
    <td>{{ x.name }}</td>
    <td>{{ x.atomicNumber }}</td>
  </tr>
</table>
<a href="#!home"> Back</a>

</div>
