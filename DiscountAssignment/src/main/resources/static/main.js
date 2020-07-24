var app = angular.module("DiscountManagement", []);
	app
			.controller(
					"DiscountController",
					function($scope, $http) {
						_refreshDiscountData();

						//view
						$scope.showModal = false;
						$scope.buttonClicked = "";
						$scope.rowcount=5;
						$scope.rowstart=0;
						$scope.sortcolom="name";
						console.log("kkk");
						$scope.viewdiscount = function(btnClicked) {
							$scope.buttonClicked = btnClicked;
							$scope.showModal = !$scope.showModal;
						};

						// HTTP POST/PUT methods for add discount  
						// Call: http://localhost:8080/discount
						$scope.submitDiscount = function() {
							var method = "";
							var url = "";
							method = "POST";
							url = '/discount';
							$http({
								method : method,
								url : url,
								data : angular.toJson($scope.discountForm),
								headers : {
									'Content-Type' : 'application/json'
								}

							}).then(_success, _error);
							_refreshDiscountData();

						};

						function _success(res) {
							_refreshDiscountData();
							_clearFormData();
						}

						function _error(res) {
							var data = res.data;
							var status = res.status;
							var header = res.header;
							var config = res.config;
							alert("Error: " + status + ":" + data);
						}

						//refresh data in grid view
						function _refreshDiscountData() {
							$http({
								method : 'GET',
								url : '/DiscountsList'
							})
									.then(
											function(res) { // success
												$scope.discountList = res.data;
												console.log(res.status)

											},
											function(res) { // error
												console.log("Error: "
														+ res.status + " : "
														+ res.data);
											});
						}

						// Clear the form
						function _clearFormData() {
							$scope.discountForm.Name = "";
							$scope.discountForm.product = "select";
							$scope.discountForm.discount = ""

							$scope.discountForm.startDate = "";
							$scope.discountForm.endDate = "";
						}
						;
					});

	////pop up modal 
	app
			.directive(
					'modal',
					function() {
						return {
							template : '<div class="modal fade">'
									+ '<div class="modal-dialog">'
									+ '<div class="modal-content">'
									+ '<div class="modal-header">'
									+ '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>'
									+ '<h4 class="modal-title">Discount ID  &nbsp;&nbsp;:&nbsp;&nbsp; {{ buttonClicked.id }} </h4>'
									+ '<h4 class="modal-title">Name  &nbsp;&nbsp;:&nbsp;&nbsp; {{ buttonClicked.name }} </h4>'
									+ '<h4 class="modal-title">product  &nbsp;&nbsp; :&nbsp;&nbsp; {{ buttonClicked.product }} </h4>'
									+ '<h4 class="modal-title">discount   &nbsp;&nbsp; :&nbsp;&nbsp; {{ buttonClicked.discount }} </h4>'
									+ '<h4 class="modal-title">Start date   &nbsp;&nbsp;:&nbsp;&nbsp; {{ buttonClicked.startDate }} </h4>'
									+ '<h4 class="modal-title">End date   &nbsp;&nbsp; :&nbsp;&nbsp; {{ buttonClicked.endDate }} </h4>'
									+ '<h4 class="modal-title">Last updated    &nbsp;&nbsp; : &nbsp;&nbsp;{{ buttonClicked.updatedDate }} </h4>'
									+ '</div>'
									+ '<div class="modal-body" ng-transclude></div>'
									+ '</div>' + '</div>' + '</div>',
							restrict : 'E',
							transclude : true,
							replace : true,
							scope : true,
							link : function postLink(scope, element, attrs) {
								scope.$watch(attrs.visible, function(value) {
									if (value == true)
										$(element).modal('show');
									else
										$(element).modal('hide');
								});

								$(element).on('shown.bs.modal', function() {
									scope.$apply(function() {
										scope.$parent[attrs.visible] = true;
									});
								});

								$(element).on('hidden.bs.modal', function() {
									scope.$apply(function() {
										scope.$parent[attrs.visible] = false;
									});
								});
							}
						};
					});
