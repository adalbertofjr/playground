//
//  ViewController.swift
//  meal-table-dinamic
//
//  Created by Adalberto Fernandes Junior on 28/11/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import UIKit

class ViewController: UITableViewController {
    
    let nomes = ["Adalberto","Fernandes","Junior","Marluzie","Diana"]

    override func viewDidLoad() {
        super.viewDidLoad()
        print("View carregada")
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return nomes.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let row = indexPath.row
        let nome = nomes[row]
        let cell = UITableViewCell(style: UITableViewCellStyle.default , reuseIdentifier: nil)
        cell.textLabel!.text = nome
        
        return cell
    }

}

