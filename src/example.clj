(ns hello-world
    (:use compojure.core, ring.adapter.jetty)
    (:require [compojure.route :as route])
    (:use hiccup.core)
)

(def hello
    (html
        [:html
            [:body
                [:h1 "Hello World"]
            ]
        ]
    )
)

(defroutes main-routes
    (GET "/" [] hello)
    ;;(GET "/" [] "<h1>Hello World</h1>")
    (route/not-found "<h1>Page not found</h1>")
)

(run-jetty main-routes {:port 8080})
