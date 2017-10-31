app.controller('ApiController', function($scope, $http, $window) {
    $scope.daftarMahasiswa = {};
    
    $scope.updateDaftarMahasiswa = function() {
      $http.get('daftar-mahasiswa').then(sukses, gagal);
      //$http.get('daftar-mahasiswa-with-paging').then(sukses, gagal);
      
      function sukses(response) {
          console.log(response);
          $scope.daftarMahasiswa = response.data;
          //console.log(response.data.content);
          //$scope.daftarMahasiswa = response.data.content;
      };
      
      function gagal(response) {
          console.log(response);
      }
    };
    
    $scope.ubah = function(mhs) {
        $window.location.href = 'edit-form?nim=' + mhs.nim;
    };
    
    $scope.hapus = function(mhs) {
        $http.delete('/hapus/' + mhs.nim).then(sukses, gagal);
        
        function sukses(response) {
            $scope.updateDaftarMahasiswa();
        };
        
        function gagal(response) {}
    };
    
    $scope.updateDaftarMahasiswa();
});