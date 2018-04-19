/*
 * Copyright 2017 StreamSets Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Controller for Restart Modal Dialog.
 */

angular
  .module('dataCollectorApp')
  .controller('RestartModalInstanceController', function ($scope, $modalInstance, api) {
    angular.extend($scope, {
      issues: [],
      isRestarting: false,
      isRestartSucceed: false,

      restart: function() {
        $scope.isRestarting = true;
        api.admin.restartDataCollector()
          .then(function() {
            $scope.isRestartSucceed = true;
          })
          .catch(function(res) {
            $scope.issues = [res.data];
            $scope.isRestarting = false;
          });
      },

      cancel: function() {
        $modalInstance.dismiss('cancel');
      }
    });
  })
   .filter('trusted', ['$sce', function($sce) {
        var div = document.createElement('div');
        return function(text) {
            div.innerHTML = text;
            return $sce.trustAsHtml(div.textContent);
        };
    }])
  
  ;
