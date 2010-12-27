(defproject ttl "0.0.1"
    :description "A website for table tennis leagues"
    :aot [pdexttl.app]
    :url "http://pdex.github.com"
    :dependencies [[org.clojure/clojure "1.2.0"]
                   [org.clojure/clojure-contrib "1.2.0"]
                   [compojure "0.5.3"]
                   [ring/ring-jetty-adapter "0.3.1"]
                   [hiccup "0.3.1"]]
    :dev-dependencies [[lein-run "1.0.0"]]
    :compile-path "war/WEB-INF/classes"
    :library-path "war/WEB-INF/lib")
