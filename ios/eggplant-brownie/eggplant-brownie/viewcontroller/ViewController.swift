//
//  ViewController.swift
//  eggplant-brownie
//
//  Created by Adalberto Fernandes Junior on 22/10/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import UIKit

protocol AddAMealDelegate {
    func add(meal:Meal)
}

class ViewController: UIViewController {
    @IBOutlet var nameTextField: UITextField?
    @IBOutlet var happinnesTextField: UITextField?
    var delegate:AddAMealDelegate?
    
    @IBAction func addButton(_ sender: AnyObject) {
        if nameTextField == nil || happinnesTextField == nil {
            return
        }
        
        let name = nameTextField!.text
        let happiness = Int(happinnesTextField!.text!)
        
        if(happiness == nil){
            return
        }
        
        let meal = Meal(name: name!, happiness: happiness!)
                
        print("eaten: \(meal.name) happiness: \(meal.happiness)")
        
        if delegate == nil {
            return
        }
        
        delegate!.add(meal: meal)
        
        if let navigation = self.navigationController{
            navigation.popViewController(animated: true)
        }
    }
   
}

