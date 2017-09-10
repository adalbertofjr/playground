//
//  Meal.swift
//  eggplant-brownie
//
//  Created by Adalberto Fernandes Junior on 22/10/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import Foundation

class Meal{
    let name:String
    let happiness:Int
    var items = Array<Item>()
    
    init(name:String, happiness:Int) {
        self.name = name
        self.happiness = happiness
    }
    
    func allCalories() -> Double {
        print("calculating")
        var total = 0.0
        for i in items {
            total += i.calories
        }
        return total
    }
}
