(defproject ttl "0.0.1"
    :description "A website for table tennis leagues"
    :aot [pdexttl.app]
    :url "http://pdex.github.com"
    :dependencies [[compojure "0.4.0-RC3"]
        [ring/ring-servlet "0.2.1"]
        [hiccup "0.2.4"]
        [appengine "0.2"]
        [com.google.appengine/appengine-api-1.0-sdk "1.4.0"]
        [com.google.appengine/appengine-api-labs "1.4.0"]]
    :dev-dependencies [[swank-clojure "1.2.0"]
        [ring/ring-jetty-adapter "0.2.0"]
        [com.google.appengine/appengine-local-runtime "1.4.0"]
        [com.google.appengine/appengine-api-stubs "1.4.0"]]
    :repl-init-script "src/local-dev.clj"
    :repositories {"maven-gae-plugin" "http://maven-gae-plugin.googlecode.com/svn/repository"}
    :compile-path "war/WEB-INF/classes"
    :library-path "war/WEB-INF/lib")
