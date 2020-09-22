<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">Board Modify</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<form role="form" action="/board/modify" method="post">

					<input type='hidden' name='currentPageNo'
						value='<c:out value="${cri.currentPageNo}"/>'> 
					<input type='hidden' name='recordsPerPage'
						value='<c:out value="${cri.recordsPerPage}"/>'> <input
						type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
					<input type='hidden' name='keyword'
						value='<c:out value="${cri.keyword}"/>'>


					<div class="form-group">
						<label>Memberid</label> <input class="form-control" name='memberid'
							value='<c:out value="${board.memberid}"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>Name</label> <input class="form-control" name='name'
							value='<c:out value="${board.name}"/>'>
					</div>

					<div class="form-group">
						<label>Age</label>
						<textarea class="form-control" name='age'><c:out
								value="${board.age}" /></textarea>
					</div>

					<div class="form-group">
						<label>Address</label> <input class="form-control" name='address'
							value='<c:out value="${board.address}"/>'>
					</div>

					<div class="form-group">
						<label>PhoneNo</label> <input class="form-control" name='phoneNo'
							value='<c:out value="${board.phoneNo}"/>'>
					</div>





					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>
				</form>


			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(document).ready(function() {

		var formObj = $("form");

		$('button').on("click", function(e) {

			e.preventDefault();

			var operation = $(this).data("oper");

			console.log(operation);

			if (operation === 'remove') {
				formObj.attr("action", "/board/remove");

			} else if (operation === 'list') {
				//move to list
				formObj.attr("action", "/board/list").attr("method", "post");

				var pageNumTag = $("input['name = currentPageNo']").clone();
				var amountTag = $("input['name = recordsPerPage']").clone();
				var keywordTag = $("input['name = keyword']").clone();
				var typeTag = $("input['name = type']").clone();

				formObj.empty();

				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
			}

			formObj.submit();
		});

	});
</script>





<%@include file="../includes/footer.jsp"%>
