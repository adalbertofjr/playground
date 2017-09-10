//
//  Item.swift
//  eggplant-brownie-swift3
//
//  Created by Adalberto Fernandes Junior on 16/11/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import Foundation

class Item: NSObject, NSCoding{
    let name:String
    let calories:Double
    
    init(name:String, calories:Double) {
        self.name = name
        self.calories = calories
    }
    
    required init?(coder aDecoder: NSCoder) {
        self.name = aDecoder.decodeObject(forKey: "name") as! String
        self.calories = aDecoder.decodeDouble(forKey: "calories")
    }
    
    func encode(with aCoder: NSCoder) {
        aCoder.encode(name, forKey: "name")
        aCoder.encode(calories, forKey: "calories")
    }
}

func == (fist:Item, second:Item) -> Bool {
    return fist.name == second.name && fist.calories == second.calories
}
