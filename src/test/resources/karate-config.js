function() {
  var config = {};
  config.baseUrl = 'http://localhost:' + java.lang.System.getProperty('karate.server.port');
  return config;
}