//
//  RemoveMealController.swift
//  eggplant-brownie-swift3
//
//  Created by Adalberto Fernandes Junior on 18/12/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import Foundation
import UIKit

class RemoveMealController{
    let controller:UIViewController
    
    init(controller: UIViewController) {
        self.controller = controller
    }
    
    
    func show(_ meal:Meal, handler: @escaping (UIAlertAction) -> Void){
        let details = UIAlertController(title: meal.name, message: "Happines: \(meal.details())", preferredStyle: UIAlertControllerStyle.alert)
        
        let cancel = UIAlertAction(title: "Cancel", style: UIAlertActionStyle.cancel, handler: nil)
        details.addAction(cancel)
        
        let remove = UIAlertAction(title: "Remove", style: UIAlertActionStyle.destructive, handler: handler )
        details.addAction(remove)
        
        
        controller.present(details, animated: true, completion: nil)
    
    }
}
