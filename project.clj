(defproject immutant-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.immutant/web "2.0.0-beta2"]
                 [org.immutant/messaging "2.0.0-beta2"]
                 [compojure "1.3.1"]]
  :main immutant-test.core
  :profiles {:uberjar {:aot [immutant-test.core]}}
  :plugins [[lein-immutant "2.0.0-beta1"]])
