(defproject ttl "0.0.1"
    :description "A website for table tennis leagues"
    :aot [pdexttl.app]
    :url "http://pdex.github.com"
    :dependencies [[org.clojure/clojure "1.2.0"]
                   [org.clojure/clojure-contrib "1.2.0"]
                   [compojure "0.5.3"]
                   [ring/ring-jetty-adapter "0.3.1"]
                   [appengine "0.4.3-SNAPSHOT"]
                   [com.google.appengine/appengine-api-1.0-sdk "1.4.0"]
                   [com.google.appengine/appengine-api-labs "1.4.0"]
                   [hiccup "0.3.1"]]
    :dev-dependencies [[lein-run "1.0.0"]
                   [com.google.appengine/appengine-api-stubs "1.4.0"]
                   [com.google.appengine/appengine-local-runtime "1.4.0"]]
    :compile-path "war/WEB-INF/classes"
    :library-path "war/WEB-INF/lib")
