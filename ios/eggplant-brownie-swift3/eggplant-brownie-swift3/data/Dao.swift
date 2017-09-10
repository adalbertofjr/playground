//
//  Dao.swift
//  eggplant-brownie-swift3
//
//  Created by Adalberto Fernandes Junior on 23/12/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import Foundation

class Dao{
    
    let mealsArchive:String
    let itemsArchive:String
    
    init() {
        let userDirs = NSSearchPathForDirectoriesInDomains(FileManager.SearchPathDirectory.documentDirectory, FileManager.SearchPathDomainMask.userDomainMask, true)
        let dir = userDirs[0]
        
        mealsArchive = "\(dir)/eggplant-brownie-meals.dados"
        itemsArchive = "\(dir)/eggplant-brownie-items.dados"
    }
    
    func save(_ meals: Array<Meal>)  {
        NSKeyedArchiver.archiveRootObject(meals, toFile: mealsArchive)
    }
    
    func load() -> Array<Meal>{
        if let loaded = NSKeyedUnarchiver.unarchiveObject(withFile: mealsArchive){
            let meals = loaded as! Array<Meal>
            
            return meals
        }
        
        
        return []
    }
    
    func save(_ items: Array<Item>)  {
        NSKeyedArchiver.archiveRootObject(items, toFile: itemsArchive)
    }
    
    func load() -> Array<Item>{
        if let loaded = NSKeyedUnarchiver.unarchiveObject(withFile: itemsArchive){
            let items = loaded as! Array<Item>
            
            return items
        }
        
        
        return []
    }
 
}
