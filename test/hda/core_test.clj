(ns hda.core-test
  (:require [clojure.test :refer :all]
            [hda.core :refer :all]))

(def local-properties-eg-01 "resources/local.properties")

(def header (slurp "resources/header.txt"))
(def result (slurp "resources/resultset.txt"))


(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(deftest parse-properties-test
  (testing "testing parsin ghda properties"
    (let [local (slurp local-properties-eg-01)]
      (is ()))))
