//
//  Alert.swift
//  eggplant-brownie-swift3
//
//  Created by Adalberto Fernandes Junior on 13/12/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import Foundation
import UIKit

class Alert{
    let controller:UIViewController
    
    
    init(controller: UIViewController) {
        self.controller = controller
    }
    
    func show(_ title:String = "Sorry", message: String = "Unexpected error"){
        let alert  = UIAlertController(title: title, message: message, preferredStyle: UIAlertControllerStyle.alert)
        let ok = UIAlertAction(title: "Ok", style: UIAlertActionStyle.cancel, handler: nil)
        alert.addAction(ok)
        controller.present(alert, animated: true, completion: nil)
    }
}
