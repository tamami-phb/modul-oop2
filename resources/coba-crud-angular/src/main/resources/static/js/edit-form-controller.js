app.controller('EditFormController', function($scope, $window, $http) {
    $scope.dataMahasiswa = {};
    
    $scope.updateData = function() {
        nim = $window.location.search.split('?')[1].split('=')[1];
        $scope.dataMahasiswa.nim = nim;
        $http.get('/get-mahasiswa-by-nim/' + nim).then(sukses, gagal);
        
        function sukses(response) {
            $scope.dataMahasiswa.nama = response.data.nama;
            $scope.dataMahasiswa.jurusan = response.data.jurusan;
        };
        
        function gagal(response) {};
    };
    
    $scope.simpan = function() {
        $http.post('/simpan-edit-data', $scope.dataMahasiswa).then(sukses, gagal);
        
        function sukses(response) {
            $window.location.href = '/';
        };
        
        function gagal(response) {}
    };
    
    $scope.updateData();
});