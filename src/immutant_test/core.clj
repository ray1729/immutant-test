(ns immutant-test.core
  (:require [clojure.string :as str]
            [compojure.core :refer [GET defroutes]]
            [compojure.route :as route]
            [immutant.messaging :as messaging]
            [immutant.util :as util]
            [immutant.web :as web]
            [ring.util.response :refer (response content-type)])
  (:gen-class))

(defn my-name
  []
  (if (util/in-container?)
    (str/replace (util/app-name) #".war$" "")
    "standalone"))

(defn hello-world
  [_]
  (-> (response (format "<h1>Hello World</h1>\n<p>%s</p>\n" (my-name)))
      (content-type "text/html")))

(defroutes routes
  (GET "/" [] hello-world)
  (route/not-found "Not found"))

(defn -main
  [& {:as args}]
  (web/run routes)
  (messaging/topic (str (my-name) "-topic")))
