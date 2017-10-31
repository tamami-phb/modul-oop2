app.controller('FormController', function($scope, $http, $window) {
    $scope.dataMahasiswa = {};
    
    $scope.simpan = function() {
        $http.post('tambah-data', $scope.dataMahasiswa).then(sukses, gagal);
        
        function sukses(response) {
            $window.location.href = '/';
        };
        
        function gagal(response) {};
    }
    
    
});